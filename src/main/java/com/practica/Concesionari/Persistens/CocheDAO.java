/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.practica.Concesionari.Persistens;

import com.practica.Concesionari.Logic.Coche;
import java.util.List;

// Interfaz para aplicar el patron DAO, me facilitara reutilizar todo este código para por ejemplo, cambiar a una base de datos.
public interface CocheDAO {
    public boolean crear(Coche coche);
    public boolean eliminar(Coche coche);
    public List<Coche> listar();
}
