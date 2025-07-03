import React from 'react';

const AddProduct = () => {
  return (
    <div>
      <h2>Add Product (Admin Only)</h2>
      <form>
        <input type="text" placeholder="Product Name" />
        <button type="submit">Add</button>
      </form>
    </div>
  );
};

export default AddProduct;
