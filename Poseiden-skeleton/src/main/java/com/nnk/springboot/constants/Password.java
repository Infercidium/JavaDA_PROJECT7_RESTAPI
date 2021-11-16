package com.nnk.springboot.constants;

public final class Password {
    private Password() { }

    /**
     * Regex for password.
     */
    public static final String REGEX
         = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*@#$%^&+=])(?=\\S+$).{8,}$";
}
