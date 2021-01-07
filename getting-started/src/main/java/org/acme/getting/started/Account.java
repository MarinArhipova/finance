package org.acme.getting.started;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.validator.constraints.Length;

import javax.inject.Inject;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
//@Cacheable
public class Account extends PanacheEntity {

    private String name;

    private Date lastSeen;

    @Valid
    @OneToMany(mappedBy = "incomes", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Item> incomes;

    @Valid
    @OneToMany(mappedBy = "expenses", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Item> expenses;

    @Valid
    @NotNull
    @OneToOne(mappedBy = "savings", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Saving saving;

    @Length(min = 0, max = 20_000)
    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }

    public List<Item> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Item> incomes) {
        this.incomes = incomes;
    }

    public List<Item> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Item> expenses) {
        this.expenses = expenses;
    }

    public Saving getSaving() {
        return saving;
    }

    public void setSaving(Saving saving) {
        this.saving = saving;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
