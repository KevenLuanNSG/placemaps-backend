package com.esoft.placemaps.helpers;

import java.util.InputMismatchException;
import java.util.Objects;

public class DocumentoHelper {
    public static Boolean documentoValido(String documento) {
        if (Objects.isNull(documento)) {
            return false;
        } else if (documento.length() == 14) {
            return cnpjValido(documento);
        } else if (documento.length() == 11) {
            return cpfValido(documento);
        }
        return false;
    }

    public static Boolean cnpjValido(String cnpj) {
        if (Objects.isNull(cnpj) || (cnpj.length() != 14) ||
                cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
                cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
                cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
                cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
                cnpj.equals("88888888888888") || cnpj.equals("99999999999999")) {
            return(false);
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 2;
            for (i=11; i>=0; i--) {
                num = (int)(cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char)((11-r) + 48);
            }

            sm = 0;
            peso = 2;
            for (i=12; i>=0; i--) {
                num = (int)(cnpj.charAt(i)- 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char)((11-r) + 48);
            }

            if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))) {
                return(true);
            } else {
                return(false);
            }
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public static boolean cpfValido(String cpf) {
        if (Objects.isNull(cpf) || (cpf.length() != 11) ||
                cpf.equals("00000000000") || cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999")) {
            return(false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                num = (int)(cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char)(r + 48);
            }

            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char)(r + 48);
            }

            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
                return(true);
            } else {
                return(false);
            }
        } catch (InputMismatchException erro) {
            return(false);
        }
    }
}
