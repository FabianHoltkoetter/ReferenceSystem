echo "Initialization for running end to end tests started."
echo "Starting the following services:"
echo "Registry, Edge, Auth, Ordering, ShoppingCart, Warehouse"
timeout 5
START /B java -jar ../infrastructure-service-registry/target/infrastructure-service-registry-1.0.jar
timeout 5
START /B java -jar ../infrastructure-service-edge/target/infrastructure-service-edge-1.0.jar
timeout 5
START /B java -jar ../infrastructure-service-auth/target/infrastructure-service-auth-1.0.jar
timeout 5
START /B java -jar ../kongo-service-ordering/kongo-ordering-service/target/kongo-ordering-service-1.0.jar
timeout 5
START /B java -jar ../kongo-service-shoppingcart/kongo-shoppingcart-service/target/kongo-shoppingcart-service-1.0.jar
timeout 5
START /B java -jar ../kongo-service-warehouse/kongo-warehouse-service/target/kongo-warehouse-service-1.0.jar
timeout 5
echo "Finished startup!"