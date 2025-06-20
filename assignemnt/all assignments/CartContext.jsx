export function CartProvider({ children }) {
  const [cart, dispatch] = useReducer(cartReducer, []);

  const addToCart = product => dispatch({ type: 'ADD', payload: product });
  const removeFromCart = id => dispatch({ type: 'REMOVE', payload: id });
  const clearCart = () => dispatch({ type: 'CLEAR' });

  const increment = id => {
    dispatch({ type: 'LOADING', payload: id });
    setTimeout(() => dispatch({ type: 'INCREMENT', payload: id }), 500);
  };

  const decrement = id => {
    dispatch({ type: 'LOADING', payload: id });
    setTimeout(() => dispatch({ type: 'DECREMENT', payload: id }), 500);
  };

  return (
    <CartContext.Provider value={{
      cart, addToCart, removeFromCart, clearCart, increment, decrement
    }}>
      {children}
    </CartContext.Provider>
  );
}
