package org.enset.comptemicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompteDTOcreat {
    private String accountNumber;
    private String Currency;
}
