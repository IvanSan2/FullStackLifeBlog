package com.ivansan.blogfinalproject.service;

import org.springframework.stereotype.Service;

@Service
public class PasswordGeneratorService {

    public String generateRandomPassword() {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        StringBuilder password;
        do {
            password = new StringBuilder();
            password.append(getRandomLowercase());
            password.append(getRandomUppercase());
            password.append(getRandomDigit());
            password.append(getRandomSpecialChar());

            int remainingLength = (int) (Math.random() * 5) + 4; // Длина от 4 до 8 символов
            for (int i = 0; i < remainingLength; i++) {
                int randomChoice = (int) (Math.random() * 4);
                switch (randomChoice) {
                    case 0 -> password.append(getRandomLowercase());
                    case 1 -> password.append(getRandomUppercase());
                    case 2 -> password.append(getRandomDigit());
                    case 3 -> password.append(getRandomSpecialChar());
                }
            }

            for (int i = 0; i < password.length(); i++) {
                int randomIndex = (int) (Math.random() * password.length());
                char temp = password.charAt(i);
                password.setCharAt(i, password.charAt(randomIndex));
                password.setCharAt(randomIndex, temp);
            }
        } while (!password.toString().matches(regex)); // Проверяем соответствие регулярному выражению

        return password.toString();
    }

    private char getRandomLowercase() {
        return (char) ((int) (Math.random() * 26) + 'a');
    }

    private char getRandomUppercase() {
        return (char) ((int) (Math.random() * 26) + 'A');
    }

    private char getRandomDigit() {
        return (char) ((int) (Math.random() * 10) + '0');
    }

    private char getRandomSpecialChar() {
        String specialChars = "@$!%*?&";
        return specialChars.charAt((int) (Math.random() * specialChars.length()));
    }
}
