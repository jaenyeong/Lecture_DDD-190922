package io.github.wotjd243.dddpokemon.game.infra;

import io.github.wotjd243.dddpokemon.game.domain.Pokemon.NationalPokedexNumber;
import io.github.wotjd243.dddpokemon.game.domain.Pokemon.Pokemon;
import io.github.wotjd243.dddpokemon.game.domain.Pokemon.PokemonRepository;
import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies;
import org.springframework.stereotype.Repository;

import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;

@Repository
public class PokeApiPokemonRepository implements PokemonRepository {

	@Override
	public Pokemon findById(final NationalPokedexNumber number) {
		final PokeApiClient pokeApiClient = new PokeApiClient();
		final PokemonSpecies pokemonSpecies = pokeApiClient.getPokemonSpecies(number.toInt());
		return new Pokemon(pokemonSpecies.getId(), pokemonSpecies.getName(), pokemonSpecies.getCaptureRate());
	}
}
