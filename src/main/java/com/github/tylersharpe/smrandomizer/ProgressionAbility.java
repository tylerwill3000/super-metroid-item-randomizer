package com.github.tylersharpe.smrandomizer;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

import static java.util.stream.Collectors.toCollection;

public enum ProgressionAbility {
  PREVENT_HEAT_DAMAGE,
  FREE_LIQUID_MOVEMENT,

  MORPH,
  CLEAR_BOMB_OBSTRUCTIONS, // Bomb obstructions that can only be cleared by vanilla bombs or power bombs
  CLEAR_BRITTLE_WALLS, // Bomb obstructions that can be cleared by vanilla bombs, screw attack or power bombs
  OPEN_MISSILE_DOORS,
  CLEAR_POWER_BOMB_OBSTRUCTIONS,
  CLEAR_SUPER_MISSILE_OBSTRUCTIONS,

  WAVE_BEAM,
  ICE_BEAM,

  PIERCING_DAMAGE, // Ability to kill armored space pirates (gold / pink)

  HIGH_JUMP,
  SPEED_BOOSTER,
  SPACE_JUMP,

  GRAPPLE;

  static Set<ProgressionAbility> allUnlockedWith(Collection<Item> items) {
    return items.stream()
            .flatMap(item -> item.abilities.stream())
            .collect(toCollection(() -> EnumSet.noneOf(ProgressionAbility.class)));
  }

}
