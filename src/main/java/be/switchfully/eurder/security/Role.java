package be.switchfully.eurder.security;

import java.util.List;

public enum Role {

        ADMIN(List.of(Feature.ADD_NEW_ITEM,
                        Feature.UPDATE_ITEM,
                        Feature.VIEW_CUSTOMERS,
                        Feature.VIEW_ALL_ORDERS_SHIPPING_TODAY,
                        Feature.VIEW_STOCK)),
        CUSTOMER(List.of(Feature.PLACE_NEW_ORDER,
                         Feature.VIEW_ORDER_REPORT,
                         Feature.REORDER_EXISTING_ORDER));

        Role(List<Feature> featureList) {
                this.featureList = featureList;
        }

        private final List<Feature> featureList;
        public boolean containsFeature(Feature feature) {
                return featureList.contains(feature);
        }
}


