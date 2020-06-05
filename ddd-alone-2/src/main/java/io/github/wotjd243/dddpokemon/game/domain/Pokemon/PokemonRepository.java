package io.github.wotjd243.dddpokemon.game.domain.Pokemon;

public interface PokemonRepository {
	Pokemon findById(NationalPokedexNumber number);
}
