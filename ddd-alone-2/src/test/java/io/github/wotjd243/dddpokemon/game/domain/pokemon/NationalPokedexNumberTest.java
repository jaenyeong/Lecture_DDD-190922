package io.github.wotjd243.dddpokemon.game.domain.pokemon;

import io.github.wotjd243.dddpokemon.game.domain.Pokemon.NationalPokedexNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NationalPokedexNumberTest {
//	@ParameterizedTest
//	@ValueSource(ints = {1, 151})
//	void valueOf(final int number) {
//		// given
//		// when
//		// then
//		NationalPokedexNumber.valueOf(number);
//	}
//
//	@ParameterizedTest
//	@ValueSource(ints = {0, 152})
//	void valueOf_ThrowIllegalArgumentException(final int number) {
//		// given
//		// when
//		// then
//		assertThatExceptionOfType(IllegalArgumentException.class)
//				.isThrownBy(() -> NationalPokedexNumber.valueOf(number));
//	}

	@Test
	void equals() {
		final NationalPokedexNumber actual = NationalPokedexNumber.valueOf(1);
		assertThat(actual).isEqualTo(NationalPokedexNumber.valueOf(1));
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 152})
	void constructor(final int number) {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> NationalPokedexNumber.valueOf(number));
	}
}
