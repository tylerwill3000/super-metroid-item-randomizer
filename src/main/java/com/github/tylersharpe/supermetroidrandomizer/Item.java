package com.github.tylersharpe.supermetroidrandomizer;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Stream;

import static com.github.tylersharpe.supermetroidrandomizer.Item.Type.MAJOR;
import static com.github.tylersharpe.supermetroidrandomizer.Item.Type.MINOR;
import static java.util.stream.Collectors.toCollection;

public enum Item {
    VARIA_SUIT(MAJOR, 1, 0x07ef, 0x5bef, 0xafef),
    GRAVITY_SUIT(MAJOR, 1, 0x0bef, 0x5fef, 0xb3ef),

    MORPH_BALL(MAJOR, 1, 0x23ef, 0x77ef, 0xcbef),
    BOMBS(MAJOR, 1, 0xe7ee, 0x3bef, 0x8fef),
    SPRING_BALL(MAJOR, 1, 0x03ef, 0x57ef, 0xabef),
    SCREW_ATTACK(MAJOR, 1, 0x1fef, 0x73ef, 0xc7ef),

    HIGH_JUMP_BOOTS(MAJOR, 1, 0xf3ee, 0x47ef, 0x9bef),
    SPEED_BOOSTER(MAJOR, 1, 0xf7ee, 0x4bef, 0x9fef),
    SPACE_JUMP(MAJOR, 1, 0x1bef, 0x6fef, 0xc3ef),

    CHARGE_BEAM(MAJOR, 1, 0xebee, 0x3fef, 0x93ef),
    WAVE_BEAM(MAJOR, 1, 0xfbee, 0x4fef, 0xa3ef),
    ICE_BEAM(MAJOR, 1, 0xefee, 0x43ef, 0x97ef),
    SPAZER_BEAM(MAJOR, 1, 0xffee, 0x53ef, 0xa7ef),
    PLASMA_BEAM(MAJOR, 1, 0x13ef, 0x67ef, 0xbbef),

    ENERGY_TANK(MAJOR, 14, 0xd7ee, 0x2bef, 0x7fef),
    RESERVE_TANK(MAJOR, 4, 0x27ef, 0x7bef, 0xcfef),

    MISSILES(MINOR, 46, 0xdbee, 0x2fef, 0x83ef),
    SUPER_MISSILES(MINOR, 10, 0xdfee, 0x33ef, 0x87ef),
    POWER_BOMBS(MINOR, 10, 0xe3ee, 0x37ef, 0x8bef),
    GRAPPLE_BEAM(MAJOR, 1, 0x17ef, 0x6bef, 0xbfef),
    XRAY(MAJOR, 1, 0x0fef, 0x63ef, 0xb7ef);

    enum Type { MAJOR, MINOR }

    static final Set<Item> MINORS = Stream.of(values())
            .filter(i -> i.type == MINOR)
            .collect(toCollection(() -> EnumSet.noneOf(Item.class)));

    final Type type;
    final int numAvailable;

    private final int normalHexValue, chozoHexValue, hiddenHexValue;

    Item(Type type, int numAvailable, int normalHexValue, int chozoHexValue, int hiddenHexValue) {
        this.type = type;
        this.numAvailable = numAvailable;
        this.normalHexValue = normalHexValue;
        this.chozoHexValue = chozoHexValue;
        this.hiddenHexValue = hiddenHexValue;
    }

    public int getHexValue(ItemLocation.Type locationType) {
        return switch (locationType) {
            case CHOZO -> chozoHexValue;
            case HIDDEN -> hiddenHexValue;
            case NORMAL -> normalHexValue;
        };
    }
}
