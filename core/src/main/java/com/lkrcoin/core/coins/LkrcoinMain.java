package com.lkrcoin.core.coins;

import com.lkrcoin.core.coins.families.PeerFamily;

/**
 * @author jestevez
 */
public class LkrcoinMain extends PeerFamily {
    private LkrcoinMain() {
        id = "lkrcoin.main";

        addressHeader = 48;
        p2shHeader = 85;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 500;
        dumpedPrivateKeyHeader = 128 + addressHeader;

        name = "LKRcoin";
        symbol = "LKR";
        uriScheme = "lkrcoin";
        bip44Index = 557;  // Agregado en https://github.com/satoshilabs/slips/blob/master/slip-0044.md
        unitExponent = 8;
        feeValue = value(10000);
        minNonDust = value(1);
        softDustLimit = value(1000000);
        softDustPolicy = SoftDustPolicy.AT_LEAST_BASE_FEE_IF_SOFT_DUST_TXO_PRESENT;
        signedMessageHeader = toBytes("LKRcoin Signed Message:\n"); // Cambio en el core https://github.com/LKRcoin/lkrcoin/commit/f4135e8cc5d8fd623c4238838b5012b1b70eed65
    }

    private static LkrcoinMain instance = new LkrcoinMain();
    public static synchronized LkrcoinMain get() {
        return instance;
    }
}
