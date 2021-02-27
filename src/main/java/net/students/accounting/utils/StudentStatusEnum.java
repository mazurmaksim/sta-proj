package net.students.accounting.utils;

public enum StudentStatusEnum {

    ORDINARY("Ordinary"), HALF_ORPHAN("HalfOrphan"), ARMY("Army"), CHERNOBYL("Chernobyl"),
    MIGRANT("Migrant"), CRIPPLE("Crypple"), THEPOOR("Thepoor"),ORPHAN("Orphan");

    private String statusName = null;

    StudentStatusEnum(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

}
