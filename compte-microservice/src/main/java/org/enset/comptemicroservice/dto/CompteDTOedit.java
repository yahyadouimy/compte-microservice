package org.enset.comptemicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompteDTOedit {
    private String accountNumber;
    private String Currency;
    private Double balance;
}
