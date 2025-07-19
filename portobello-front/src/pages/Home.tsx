import { useState, useEffect } from "react";
import Sidebar from "../components/Sidebar";
import ModalNewOrder from "../components/ModalNewOrder";
import { Pedido, Customer, Item } from "../types";

type PedidoInput = Omit<Pedido, "orderNumber" | "date" | "id">;

export default function Home() {
  const [pedidos, setPedidos] = useState<Pedido[]>([]);
  const [pedidoSelecionado, setPedidoSelecionado] = useState<Pedido | null>(
    null
  );
  const [modalAberto, setModalAberto] = useState(false);

  useEffect(() => {
    fetch("http://localhost:8080/order")
      .then((res) => res.json())
      .then((data) => setPedidos(data))
      .catch((err) => console.error("Erro ao buscar pedidos:", err));
  }, []);

  const criarNovoPedido = (pedido: PedidoInput) => {
    fetch("http://localhost:8080/order", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(pedido),
    })
      .then((response) => {
        if (!response.ok) throw new Error("Erro ao criar pedido");
        return response.json();
      })
      .then((novoPedido: Pedido) => {
        setPedidos((old) => [...old, novoPedido]);
        setPedidoSelecionado(novoPedido);
        setModalAberto(false);
      })
      .catch((error) => {
        console.error(error);
        alert("Falha ao criar pedido");
      });
  };

  console.log("Pedido selecionado:", pedidoSelecionado);

  return (
    <div className="flex">
      <Sidebar
        pedidos={pedidos}
        onSelecionarPedido={setPedidoSelecionado}
        onNovoPedido={() => setModalAberto(true)}
      />
      <main className="flex-1 p-6 bg-white rounded shadow">
        {pedidoSelecionado ? (
          <div className="flex-1 p-6 bg-white rounded shadow">
            <h1 className="text-2xl font-bold mb-4">
              Detalhes do Pedido #{pedidoSelecionado.orderNumber}
            </h1>

            <p>
              <strong>Cliente:</strong> {pedidoSelecionado.customer.name}
            </p>
            <p>
              <strong>Data:</strong>{" "}
              {new Date(pedidoSelecionado.date).toLocaleDateString()}
            </p>
            <p>
              <strong>Valor Total:</strong> R${" "}
              {pedidoSelecionado.totalValue.toFixed(2)}
            </p>
            <p>
              <strong>Quantidade de Produtos:</strong>{" "}
              {pedidoSelecionado.items.reduce(
                (acc, item) => acc + item.quantity,
                0
              )}
            </p>

            <h2 className="text-xl font-semibold mt-6 mb-2">
              Produtos Comprados:
            </h2>
            <table className="w-full table-auto border-collapse">
              <thead>
                <tr className="bg-gray-200">
                  <th className="border px-4 py-2">Produto</th>
                  <th className="border px-4 py-2">Quantidade</th>
                  <th className="border px-4 py-2">Preço Unitário</th>
                  <th className="border px-4 py-2">Subtotal</th>
                </tr>
              </thead>
              <tbody>
                {pedidoSelecionado.items.map((item, index) => (
                  <tr key={index} className="text-center">
                    <td className="border px-4 py-2">{item.productName}</td>
                    <td className="border px-4 py-2">{item.quantity}</td>
                    <td className="border px-4 py-2">
                      R$ {item.unityPrice.toFixed(2)}
                    </td>
                    <td className="border px-4 py-2">
                      R$ {(item.quantity * item.unityPrice).toFixed(2)}
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        ) : (
          <p className="flex-1 p-6 bg-white rounded shadow">
            Selecione um pedido para ver os detalhes.
          </p>
        )}
      </main>

      {modalAberto && (
        <ModalNewOrder
          onClose={() => setModalAberto(false)}
          onSalvar={criarNovoPedido}
        />
      )}
    </div>
  );
}
