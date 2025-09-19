package com.solvians.showcase.certificate;

// TODO: Consider adding Lombok annotations to reduced boilerplatee
public class CertificateUpdate {

    private final long timestamp;
    private final String isin;
    private final double bidPrice;
    private final int bidSize;
    private final double askPrice;
    private final int askSize;

    public CertificateUpdate(long timestamp,
                             String isin,
                             double bidPrice,
                             int bidSize,
                             double askPrice,
                             int askSize) {
        this.timestamp = timestamp;
        this.isin = isin;
        this.bidPrice = bidPrice;
        this.bidSize = bidSize;
        this.askPrice = askPrice;
        this.askSize = askSize;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getIsin() {
        return isin;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public int getBidSize() {
        return bidSize;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public int getAskSize() {
        return askSize;
    }

    @Override
    public String toString() {
        return String.format(java.util.Locale.ROOT, //todo find a better way. currently used this to force decimal points due to German local gives comma for decimals
                "%d,%s,%.2f,%d,%.2f,%d",
                timestamp, isin, bidPrice, bidSize, askPrice, askSize);
    }
}
