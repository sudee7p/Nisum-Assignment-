import React from 'react';
import { useDispatch } from 'react-redux';
import { addToCart } from '../store/cartSlice';

const products = [
  { id: 1, name: 'Phone', price: 500 },
  { id: 2, name: 'Laptop', price: 1500 },
];

const ProductList = () => {
  const dispatch = useDispatch();

  return (
    <div style={{ padding: 20 }}>
      <h2>Products</h2>
      {products.map((product) => (
        <div key={product.id} style={{ marginBottom: 10 }}>
          <p>{product.name} - ₹{product.price}</p>
          <button onClick={() => dispatch(addToCart(product))}>Add to Cart</button>
        </div>
      ))}
    </div>
  );
};

export default ProductList;
