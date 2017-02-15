package utils;

import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;

import java.io.Serializable;
import java.util.*;

/**
 * Provides integration tests with a fake authentication object to be used for injecting it into springs security context.
 */
public class TestAuthenticationProvider {

    /**
     * Create a Test Authentication object with all available authorities of this service.
     *
     * @return A OAuth2Authentication-Object with all available authorities of this service.
     */
    public static OAuth2Authentication getTestAuthenticationWithAll() {
        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList(
                "ordering_READ_OrderingItem",
                "ordering_WRITE_OrderingItem",
                "ordering_DELETE_OrderingItem",
                "ordering_BUSINESSACTION_OrderCart",
                "ordering_BUSINESSACTION_SendInvoice",
                "ordering_BUSINESSACTION_CancelOrder");
        return getTestAuthenticationWithSpecific(authorityList);
    }

    public static OAuth2Authentication getTestAuthenticationWithSpecific(List<GrantedAuthority> authorityList) {
        return new OAuth2Authentication(
                getOauth2Request(authorityList),
                getAuthentication(authorityList)
        );
    }

    /**
     * Create a Test Authentication object with a given number ob authorities.
     * @param authorityList Authorities that should be added to the authentication object.
     * @return A OAuth2Authentication-Object with all given authorities.
     */
    private static OAuth2Request getOauth2Request(List<GrantedAuthority> authorityList) {
        String clientId = "acme";
        Map<String, String> requestParameters = Collections.emptyMap();
        boolean approved = true;
        String redirectUrl = "http://testing-redirect-url.com";
        Set<String> responseTypes = Collections.emptySet();
        Set<String> scopes = Collections.emptySet();
        Set<String> resourceIds = Collections.emptySet();
        Map<String, Serializable> extensionProperties = Collections.emptyMap();

        return new OAuth2Request(requestParameters, clientId, authorityList,
                approved, scopes, resourceIds, redirectUrl, responseTypes, extensionProperties);
    }

    private static Authentication getAuthentication(List<GrantedAuthority> authorityList) {
        User userPrincipal = new User("admin",
                "",
                true,
                true,
                true,
                true,
                authorityList);

        HashMap<String, String> details = new HashMap<String, String>();
        details.put("user_name", "admin");
        details.put("email", "admin@admin.org");
        details.put("name", "Admin Admin");

        TestingAuthenticationToken token = new TestingAuthenticationToken(userPrincipal, null, authorityList);
        token.setAuthenticated(true);
        token.setDetails(details);

        return token;
    }
}
