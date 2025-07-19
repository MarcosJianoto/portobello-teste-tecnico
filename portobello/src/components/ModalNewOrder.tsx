import { useState, useEffect, FormEvent } from "react";
import customers from "../data/customers.js";
import products from "../data/products.js";
import { Pedido } from "../types";
type Product = {
  id: string;
  productName: string;
  unityPrice: number;
};

type SelectedProduct = Product & { quantity: number };
type PedidoInput = Omit<Pedido, "orderNumber" | "date" | "id">;

type ModalNovoPedidoProps = {
  onClose: () => void;
  onSalvar: (pedido: PedidoInput) => void;
};

export default function ModalNovoPedido({
  onClose,
  onSalvar,
}: ModalNovoPedidoProps) {
  const [clienteId, setClienteId] = useState<string>("");
  const [selectedProducts, setSelectedProducts] = useState<SelectedProduct[]>(
    []
  );
  const [totalValue, setTotalValue] = useState<number>(0);

  useEffect(() => {
    const total = selectedProducts.reduce(
      (acc, prod) => acc + prod.unityPrice * prod.quantity,
      0
    );
    setTotalValue(total);
  }, [selectedProducts]);

  const handleAddProduct = (productId: string) => {
    const prod = products.find((p) => p.id === productId);
    if (prod && !selectedProducts.some((p) => p.id === prod.id)) {
      setSelectedProducts([...selectedProducts, { ...prod, quantity: 1 }]);
    }
  };

  const handleQuantityChange = (productId: string, newQuantity: string) => {
    const updatedProducts = selectedProducts.map((p) =>
      p.id === productId ? { ...p, quantity: Number(newQuantity) } : p
    );
    setSelectedProducts(updatedProducts);
  };

  const handleRemoveProduct = (productId: string) => {
    setSelectedProducts(selectedProducts.filter((p) => p.id !== productId));
  };

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault();
    if (!clienteId) return alert("Selecione um cliente");
    if (selectedProducts.length === 0)
      return alert("Selecione ao menos um produto");

    const cliente = customers.find((c) => c.id === clienteId);
    if (!cliente) return alert("Cliente inválido");

    const pedido: PedidoInput = {
      customer: cliente,
      items: selectedProducts.map((p) => ({
        id: p.id,
        productName: p.productName,
        quantity: p.quantity,
        unityPrice: p.unityPrice,
      })),
      totalValue,
    };

    await onSalvar(pedido);
  };

  return (
    <div className="fixed inset-0 backdrop bg-[rgba(0,0,0,0.75)] flex justify-center items-center">
      <div className="bg-white rounded p-6 w-200 max-h-[90vh] overflow-auto">
        <h2 className="text-xl font-bold mb-4">Novo Pedido</h2>
        <form onSubmit={handleSubmit}>
          <label className="block mb-2">
            Cliente:
            <select
              className="border p-2 w-full"
              value={clienteId}
              onChange={(e) => setClienteId(e.target.value)}
              required
            >
              <option value="">-- Selecione --</option>
              {customers.map((c) => (
                <option key={c.id} value={c.id}>
                  {c.name}
                </option>
              ))}
            </select>
          </label>

          <label className="block mb-4">
            Produtos:
            <select
              className="border p-2 w-full"
              onChange={(e) => handleAddProduct(e.target.value)}
              value=""
            >
              <option value="">-- Adicionar produto --</option>
              {products.map((p) => (
                <option key={p.id} value={p.id}>
                  {p.productName} — R$ {p.unityPrice.toFixed(2)}
                </option>
              ))}
            </select>
          </label>

          <ul className="mb-4">
            {selectedProducts.map((p) => (
              <li
                key={p.id}
                className="flex justify-between items-center mb-1 gap-2"
              >
                <span className="flex-1">
                  {p.productName} — R$ {p.unityPrice.toFixed(2)}
                </span>
                <input
                  type="number"
                  min="1"
                  value={p.quantity}
                  onChange={(e) => handleQuantityChange(p.id, e.target.value)}
                  className="w-16 border p-1"
                />
                <button
                  type="button"
                  onClick={() => handleRemoveProduct(p.id)}
                  className="text-red-600 font-bold px-2"
                >
                  X
                </button>
              </li>
            ))}
          </ul>

          <label className="block mb-4">
            <p className="mb-4 font-semibold">
              Valor total: R$ {totalValue.toFixed(2)}
            </p>
          </label>

          <div className="flex justify-end gap-2">
            <button
              type="button"
              onClick={onClose}
              className="px-4 py-2 bg-gray-300 rounded"
            >
              Cancelar
            </button>
            <button
              type="submit"
              className="px-4 py-2 bg-blue-600 text-white rounded"
            >
              Salvar
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
