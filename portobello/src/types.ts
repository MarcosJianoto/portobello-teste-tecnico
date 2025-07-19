export type Item = {
  id?: string;
  productName: string;
  unityPrice: number;
  quantity: number;
};

export type Customer = {
  id?: string;
  name: string;
  email?: string;
};

export type Pedido = {
  id?: string;
  orderNumber: number;
  date: string;
  customer: Customer;
  items: Item[];
  totalValue: number;
};
