package de.moegn.blueboxgames.service.api;

public interface IKeyAPI {
	GeneratedGameKey generateKey(KeyGenerationRequest request) throws KeyGenerationException;

	ReturnedGameKey returnKey(KeyReturnRequest request) throws KeyReturnException;
}
