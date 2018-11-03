package io.fdlessard.codebites.magiceightball.basic.services;

import io.fdlessard.codebites.magiceightball.basic.domain.MagicEightBallAnswer;

import java.util.List;

public interface MagicEightBallService {

    MagicEightBallAnswer shake();
    List<MagicEightBallAnswer> getAll();
}
