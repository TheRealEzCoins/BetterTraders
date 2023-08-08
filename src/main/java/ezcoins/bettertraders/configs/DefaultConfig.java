package ezcoins.bettertraders.configs;

import ezcoins.bettertraders.BetterTraders;
import ezcoins.bettertraders.enums.TradeType;

import static ezcoins.bettertraders.BetterTraders.tradeConfig;

public class DefaultConfig {

    public static int getTradeAmount(TradeType tradeType) {
        return BetterTraders.config.getInt("Trade-amount." + tradeType.name());
    }
}
