package com.platzi.market.persistence;
import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int id_categoria){
        return productCrudRepository.findByIdCategoriaOrderByNombreAsc(id_categoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productCrudRepository.findByCantidadStockLessThanAndEstado(cantidad,true);
    }

    public Optional<Producto> getProducto(int idProducto){
        return productCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productCrudRepository.deleteById(idProducto);
    }

}
