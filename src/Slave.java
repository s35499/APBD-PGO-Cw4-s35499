import java.util.UUID;
import enums.StatusOfVitalSigns;

public class Slave {
    private final String uuid;
    private final String name;
    private final String surname;

    private StatusOfVitalSigns statusOfVitalSigns;
    private int levelOfExhaustion;
    private int levelOfReadinessToRebel;

    public Slave(String name, String surname) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.statusOfVitalSigns = StatusOfVitalSigns.HEALTHY;
        this.levelOfExhaustion = 0;
        this.levelOfReadinessToRebel = 0;
    }

    public final String getUuid() {
        return uuid;
    }

    public final String getName() {
        return name;
    }

    public final String getSurname() {
        return surname;
    }

    public StatusOfVitalSigns getStatusOfVitalSigns() {
        return statusOfVitalSigns;
    }

    public int getLevelOfExhaustion() {
        return levelOfExhaustion;
    }

    public int getLevelOfReadinessToRebel() {
        return levelOfReadinessToRebel;
    }

    protected final boolean isDead() {
        return statusOfVitalSigns == StatusOfVitalSigns.DEAD;
    }

    protected final boolean isRebelling() {
        return levelOfReadinessToRebel >= 100;
    }

    protected final void requireAlive() {
        if (isDead()) {
            throw new IllegalStateException(
                String.format("'%s' '%s' is dead!", name, surname)
            );
        }
    }

    protected final void changeExhaustion(int value) {
        requireAlive();

        levelOfExhaustion = clamp(levelOfExhaustion + value);
        updateStatus();
    }

    protected final void changeReadinessToRebel(int value) {
        requireAlive();

        levelOfReadinessToRebel = clamp(levelOfReadinessToRebel + value);
    }

    protected final void reduceExhaustion(int value) {
        changeExhaustion(-value);
    }

    protected final void increaseExhaustion(int value) {
        changeExhaustion(value);
    }

    protected final void reduceReadinessToRebel(int value) {
        changeReadinessToRebel(-value);
    }

    protected final void increaseReadinessToRebel(int value) {
        changeReadinessToRebel(value);
    }

    private void updateStatus() {
        if (levelOfExhaustion >= 100) {
            statusOfVitalSigns = StatusOfVitalSigns.DEAD;
            System.out.println(String.format("'%s' '%s' is dead!", name, surname));
        } else if (levelOfExhaustion >= 70) {
            statusOfVitalSigns = StatusOfVitalSigns.CRITICAL;
        } else if (levelOfExhaustion >= 40) {
            statusOfVitalSigns = StatusOfVitalSigns.EXHAUSTED;
        } else {
            statusOfVitalSigns = StatusOfVitalSigns.HEALTHY;
        }
    }

    private static int clamp(int value) {
        return Math.max(0, Math.min(100, value));
    }

    public void workSoftly() {
        requireAlive();

        if (isRebelling()) {
            System.out.println(String.format("'%s' '%s' is rebelling!", name, surname));

            return;
        }

        System.out.println("Working softly...");

        reduceExhaustion(5);
        reduceReadinessToRebel(5);
    }

    public void workHard() {
        requireAlive();

        if (isRebelling()) {
            System.out.println(String.format("'%s' '%s' is rebelling!", name, surname));

            return;
        }

        System.out.println("Working hard...");

        increaseExhaustion(20);
        increaseReadinessToRebel(15);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Slave)) {
            return false;
        }

        Slave other = (Slave) obj;

        return this.uuid.equals(other.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return String.format(
            "Slave{uuid='%s', name='%s', surname='%s', status='%s', exhaustion=%d, rebellion=%d}",
            uuid,
            name,
            surname,
            statusOfVitalSigns,
            levelOfExhaustion,
            levelOfReadinessToRebel
        );
    }
}