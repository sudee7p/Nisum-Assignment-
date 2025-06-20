function cartReducer(state, action) {
  switch (action.type) {
    case 'ADD':
      const exists = state.find(item => item.id === action.payload.id);
      if (exists) {
        return state.map(item =>
          item.id === action.payload.id
            ? { ...item, qty: item.qty + 1, loading: false }
            : item
        );
      }
      return [...state, { ...action.payload, qty: 1, loading: false }];

    case 'REMOVE':
      return state.filter(item => item.id !== action.payload);

    case 'CLEAR':
      return [];

    case 'INCREMENT':
      return state.map(item =>
        item.id === action.payload ? { ...item, qty: item.qty + 1, loading: false } : item
      );

    case 'DECREMENT':
      return state.map(item =>
        item.id === action.payload && item.qty > 1
          ? { ...item, qty: item.qty - 1, loading: false }
          : item
      );

    case 'LOADING':
      return state.map(item =>
        item.id === action.payload ? { ...item, loading: true } : item
      );

    default:
      return state;
  }
}
