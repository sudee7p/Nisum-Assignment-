import React from 'react';
import { useSelector } from 'react-redux';

const Cart = () => {
  const items = useSelector((state) => state.cart.items);

  const total = items.reduce((acc, item) => acc + item.price, 0);

  return (
    <div style={{ float: 'right', padding: 10 }}>
      <h4>Cart</h4>
      <p>Items: {items.length}</p>
      <p>Total: ${total}</p>
    </div>
  );
};

export default Cart;
