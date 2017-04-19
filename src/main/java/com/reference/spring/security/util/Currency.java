package com.reference.spring.security.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public enum Currency {
    INDIAN_RUPEE(1, "INR", "Indian Rupee", "Rs."), US_DOLLAR(2, "USD", "US Dollor", ""), EURO(3, "EUR", "Euro", ""), SRILANKA_RUPEES(
            4, "LKR", "Sri Lankan Rupee", "LKR"), THAILAND_BAHT(5, "THB", "Thai Baht", "THB"), POUND(6, "GBP",
            "British Pound", ""), SINGAPORE_DOLLAR(7, "SGD", "Singapore Dollar", ""), SWISS_FRANC(8, "CHF",
            "Swiss Franc", ""), ZAR(9, "ZAR", "South African Rand", ""), CHILEAN_PESO(10, "CLP", "Chilean Peso", ""), GTQ_DOLLER(12,
            "GTQ", "Guatemalan Quetzal", ""), AED(13, "AED", "United Arab Emirates Dirham", ""), IDR(14, "IDR", "Indonesian Rupiah", ""), OMR(15, "OMR",
            "Omani Rial", ""), PLN(16, "PLN", "Polish Zloty", ""), MXN(17, "MXN", "Mexican Pesos", ""), MYR(18, "MYR",
            "Malaysian Ringgit", ""), BRL(19, "BRL", "Brazil Real", ""), ARS(20, "ARS", "Argentina", ""), PHL(21,
            "PHL", "Philippine peso", ""), COP(22, "COP", "Colombian peso", ""), PHP(23, "PHP", "Philippines Peso", "");




    private static final Logger                 logger            = Logger.getLogger(Currency.class);
    private static final Map<Integer, Currency> s_currencies      = new HashMap<Integer, Currency>();
    private static final Map<String, Currency>  s_currenciesByIso = new HashMap<String, Currency>();
    private final int                           m_typeId;
    private final String                        m_isoCode;
    private final String                        m_description;
    private final String                        m_prefix;

    static {
        try {
            for (Currency currency : Currency.values()) {
                s_currencies.put(currency.getTypeId(), currency);
                s_currenciesByIso.put(currency.getIsoCode(), currency);
            }
        } catch (Exception e) {
            logger.error("Fatal Error: Unable to initialize currencies.", e);
        }
    }

    private Currency(int typeId, String isoCode, String description, String prefix) {
        m_typeId = typeId;
        m_isoCode = isoCode;
        m_description = description;
        m_prefix = prefix;
    }

    public static Currency getCurrencyById(int typeId) {
        return s_currencies.get(typeId);
    }

    public static Currency getCurrencyByIsoCode(String code) {
        return s_currenciesByIso.get(code);
    }

    public int getTypeId() {
        return m_typeId;
    }

    public String getDescription() {
        return m_description;
    }

    public String getIsoCode() {
        return m_isoCode;
    }

    public String getPrefix() {
        return m_prefix;
    }
}
