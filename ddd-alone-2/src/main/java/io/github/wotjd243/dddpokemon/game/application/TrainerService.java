package io.github.wotjd243.dddpokemon.game.application;

import io.github.wotjd243.dddpokemon.game.domain.Trainer.Trainer;
import io.github.wotjd243.dddpokemon.game.domain.Trainer.TrainerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrainerService {
	private final TrainerRepository trainerRepository;

	public TrainerService(TrainerRepository trainerRepository) {
		this.trainerRepository = trainerRepository;
	}

	@Transactional
	public Trainer join(final String id) {
		return trainerRepository.save(new Trainer(id));
	}
}
