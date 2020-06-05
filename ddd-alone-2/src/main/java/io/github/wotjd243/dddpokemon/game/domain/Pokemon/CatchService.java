package io.github.wotjd243.dddpokemon.game.domain.Pokemon;

import io.github.wotjd243.dddpokemon.game.domain.PokeBall.PokeBall;
import io.github.wotjd243.dddpokemon.game.domain.PokeBall.PokeBallRepository;
import io.github.wotjd243.dddpokemon.game.domain.Trainer.Trainer;
import io.github.wotjd243.dddpokemon.game.domain.Trainer.TrainerRepository;
import io.github.wotjd243.dddpokemon.utils.RandomUtils;
import org.springframework.stereotype.Component;

/**
 * 포획률 = (포켓몬의 포획률 * 몬스터볼 보정 승수 * (레벨 11 이상의 트레이너 레벨 / 10)) * 100 / 255
 */
@Component
public class CatchService {
	private static final int CENT = 100;
	private static final int MINIMUM_CAPTURE_RATE = 255;
	private final TrainerRepository trainerRepository;
	private final PokemonRepository pokemonRepository;
	private final PokeBallRepository pokeBallRepository;

	public CatchService(
			final TrainerRepository trainerRepository,
			final PokemonRepository pokemonRepository,
			final PokeBallRepository pokeBallRepository
	) {
		this.trainerRepository = trainerRepository;
		this.pokemonRepository = pokemonRepository;
		this.pokeBallRepository = pokeBallRepository;
	}

	public boolean catches(final String trainerId, final Integer number, final Long pokeBallId) {
		final Trainer trainer = getTrainer(trainerId);
		final Pokemon pokemon = getPokemon(number);
		final PokeBall pokeBall = getPokeBall(pokeBallId);

		final boolean catchable = catchable(trainer, pokemon, pokeBall);
		if (catchable) {
			trainer.addPokemon(pokemon.getNumber(), pokemon.getName());
		}
		return catchable;
	}

	private boolean catchable(final Trainer trainer, final Pokemon pokemon, final PokeBall pokeBall) {
		return RandomUtils.nextInt(1, 100)
				<= percentage(pokemon.getCaptureRate() * pokeBall.getMultiplier() * trainer.bonus());
	}

	private double percentage(final double rate) {
		return rate * CENT / MINIMUM_CAPTURE_RATE;
	}

	private Trainer getTrainer(final String trainerId) {
		return trainerRepository.findById(trainerId)
				.orElseThrow(IllegalArgumentException::new)
				;
	}

	private Pokemon getPokemon(final Integer number) {
		return pokemonRepository.findById(NationalPokedexNumber.valueOf(number));
	}

	private PokeBall getPokeBall(final Long pokeBallId) {
		return pokeBallRepository.findById(pokeBallId)
				.orElseThrow(IllegalArgumentException::new);
	}
}
