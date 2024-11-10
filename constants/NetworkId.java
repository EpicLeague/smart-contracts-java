package constants;

public enum NetworkId {

    ETH_MAINNET(1),
    BNB_MAINNET(56),
    BNB_TESTNET(97),
    POLYGON_MAINNET(137),
    @Deprecated  POLYGON_TESTNET_MUMBAI(80001),
    POLYGON_TESTNET_AMOY(80002),
    HMV_MAINNET(19011),
    HMV_TESTNET(40875)
    ;

    private final int id;

    NetworkId(int networkId) {
        this.id = networkId;
    }

    public int getId() {
        return id;
    }

    public static NetworkId fromId(int id) {
        for (NetworkId networkId : NetworkId.values()) {
            if (networkId.getId() == id) {
                return networkId;
            }
        }
        return null;
    }
}
