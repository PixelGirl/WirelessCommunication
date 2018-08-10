package moe.pixelgirl.wirelesscommunication.common.util;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.util
 * Created by Pixel.
 */
public class Location {
    private int x;
    private int y;
    private int z;

    public Location(){
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Location(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public static Location add(Location first, Location second) {
        return new Location(first.x + second.x, first.y + second.y, first.z + second.z);
    }

    public static Location subtract(Location first, Location second) {
        return new Location(first.x - second.x, first.y - second.y, first.z - second.z);
    }

    public void copyFrom(Location location) {
        this.x = location.x;
        this.y = location.y;
        this.z = location.z;
    }

    public void reset() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
}
