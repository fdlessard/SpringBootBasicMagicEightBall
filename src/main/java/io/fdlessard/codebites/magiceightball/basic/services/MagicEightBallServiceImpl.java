package io.fdlessard.codebites.magiceightball.basic.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.fdlessard.codebites.magiceightball.basic.domain.MagicEightBallAnswer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MagicEightBallServiceImpl implements MagicEightBallService {

    public MagicEightBallAnswer shake() {

        List<MagicEightBallAnswer> magicEightBallAnswers = loadMagicEightBallAnswers();
        int randomResponseIndex = generateRandomNumberBetween(1, magicEightBallAnswers.size());

        return magicEightBallAnswers.get(randomResponseIndex);
    }

    public List<MagicEightBallAnswer> getAll() {
        return loadMagicEightBallAnswers();
    }

    private static int generateRandomNumberBetween(int lowerBound, int upperBound) {
        if (upperBound <= lowerBound) {
            return upperBound;
        }
        return (new Random()).nextInt(upperBound - lowerBound) + lowerBound;
    }

    private List<MagicEightBallAnswer> loadMagicEightBallAnswers() {

        ClassPathResource classPathResource = new ClassPathResource("MagicEightBallAnswers.yml");
        List<MagicEightBallAnswer> magicEightBallAnswers = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        try {
            magicEightBallAnswers = mapper.readValue(classPathResource.getFile(), new TypeReference<List<MagicEightBallAnswer>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return magicEightBallAnswers;
    }
}
