/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.cinema.boundary;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ospite
 */
public class ProgDTO {
    
    public Long id;
    @NotNull
    @Future
    public LocalDate il;
    @NotNull
    @Min(1)
    public BigDecimal prezzo;
    @JsonbProperty(value = "tutte_sale")
    public boolean tutteSale = false;
    public List<Long> sale_id = new ArrayList<>();
}
