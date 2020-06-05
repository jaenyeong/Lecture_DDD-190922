package io.github.wotjd243.dddpokemon.game.domain.Pokemon;

import java.util.Objects;

public class Pokemon {
    private final NationalPokedexNumber number;
    private final String name;
    private final CaptureRate captureRate;

    public Pokemon(final int number, final String name, final int captureRate) {
        this(NationalPokedexNumber.valueOf(number), name, CaptureRate.valueOf(captureRate));
    }

    public Pokemon(final NationalPokedexNumber number, final String name, final CaptureRate captureRate) {
        this.number = number;
        this.name = name;
        this.captureRate = captureRate;
    }

    public int getNumber() {
        return number.toInt();
    }

    public String getName() {
        return name;
    }

    public int getCaptureRate() {
        return captureRate.toInt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(getNumber(), pokemon.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
