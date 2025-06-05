function formatId(id: String | number): string {
  if (typeof id == "string"){
    return id.toUpperCase();
    
  }else {
    return `ID - ${id.toFixed(0)}`;
  }
}
console.log(formatId("abc-123"));
console.log(formatId(42));