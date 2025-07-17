abstract class Room {
    private int roomNumber;
    private int maxOccupancy;
    private double pricePerNight;
    private boolean isReserved;

    public Room(int roomNumber, int maxOccupancy, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.maxOccupancy = maxOccupancy;
        this.pricePerNight = pricePerNight;
        this.isReserved = false;
    }
    public int getRoomNumber() {
        return roomNumber;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", maxOccupancy=" + maxOccupancy +
                ", pricePerNight=" + pricePerNight +
                ", isReserved=" + isReserved +
                '}';
    }
}

