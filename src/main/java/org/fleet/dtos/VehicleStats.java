package org.fleet.dtos;

public class VehicleStats {
    private long total;
    private long available;
    private long rented;

    public VehicleStats(long total, long available, long rented) {
        this.total = total;
        this.available = available;
        this.rented = rented;
    }

    public long getTotal() {
        return total;
    }

    public long getAvailable() {
        return available;
    }

    public long getRented() {
        return rented;
    }
}
