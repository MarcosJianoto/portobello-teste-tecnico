import type { Pedido } from "../types";

export type PedidoInput = Omit<Pedido, "id" | "orderNumber" | "date">;


const API_URL = "http://localhost:8080/order";

export async function createOrder(order: Pedido) {
  const response = await fetch(API_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(order),
  });

  if (!response.ok) throw new Error("Erro ao criar pedido");

  const text = await response.text();
  return text ? JSON.parse(text) : null;
}

export async function getOrders() {
  const response = await fetch(API_URL);
  if (!response.ok) throw new Error("Erro ao buscar pedidos");
  return await response.json();
}

export async function getOrderById(id: string) {
  const response = await fetch(`${API_URL}/${id}`);
  if (!response.ok) throw new Error("Pedido não encontrado");
  return await response.json();
}
