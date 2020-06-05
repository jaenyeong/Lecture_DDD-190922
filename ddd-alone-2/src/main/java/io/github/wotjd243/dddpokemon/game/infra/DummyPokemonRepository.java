package io.github.wotjd243.dddpokemon.game.infra;

import io.github.wotjd243.dddpokemon.game.domain.Pokemon.NationalPokedexNumber;
import io.github.wotjd243.dddpokemon.game.domain.Pokemon.Pokemon;
import io.github.wotjd243.dddpokemon.game.domain.Pokemon.PokemonRepository;

public class DummyPokemonRepository implements PokemonRepository {
	@Override
	public Pokemon findById(final NationalPokedexNumber number) {
		return DummyPokemonData.get(number);
	}
}
