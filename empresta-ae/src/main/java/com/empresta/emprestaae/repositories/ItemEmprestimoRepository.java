package com.empresta.emprestaae.repositories;

import com.empresta.emprestaae.entities.ItemEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemEmprestimoRepository extends JpaRepository<ItemEmprestimo, Long> {
}
