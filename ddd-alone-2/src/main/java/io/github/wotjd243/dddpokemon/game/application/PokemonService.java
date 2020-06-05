package io.github.wotjd243.dddpokemon.game.application;

import io.github.wotjd243.dddpokemon.game.domain.Pokemon.NationalPokedexNumber;
import io.github.wotjd243.dddpokemon.game.domain.Pokemon.Pokemon;
import io.github.wotjd243.dddpokemon.game.domain.Pokemon.PokemonRepository;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
	private final PokemonRepository pokemonRepository;

	public PokemonService(PokemonRepository pokemonRepository) {
		this.pokemonRepository = pokemonRepository;
	}

	public Pokemon find(final Integer number) {
		return getPokemon(number);
	}

	public Pokemon getPokemon(final int number) {
		return pokemonRepository.findById(NationalPokedexNumber.valueOf(number));
	}
}
