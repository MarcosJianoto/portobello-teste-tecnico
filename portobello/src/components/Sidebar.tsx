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

type SidebarProps = {
  pedidos: Pedido[];
  onSelecionarPedido: (pedido: Pedido) => void;
  onNovoPedido: () => void;
};

export default function Sidebar({
  pedidos,
  onSelecionarPedido,
  onNovoPedido,
}: SidebarProps) {
  const pedidosExibidos = pedidos.slice().reverse();

  return (
    <aside className="w-64 h-screen overflow-y-auto bg-gray-800 text-white p-4">
      <h2 className="text-xl font-bold mb-4">Pedidos</h2>
      <nav className="flex flex-col gap-2">
        <button
          className="bg-blue-500 hover:bg-blue-600 text-white px-3 py-2 rounded"
          onClick={onNovoPedido}
        >
          📝 Novo Pedido
        </button>

        {pedidos.length === 0 ? (
          <p className="mt-4 text-gray-400 italic">
            Nenhum pedido registrado ainda.
          </p>
        ) : (
          <ul className="mt-4 space-y-2">
            {pedidosExibidos.map((pedido) => (
              <li
                key={pedido.id}
                className="hover:bg-gray-700 p-2 rounded cursor-pointer"
                onClick={() => onSelecionarPedido(pedido)}
              >
                Pedido #{pedido.orderNumber}
              </li>
            ))}
          </ul>
        )}
      </nav>
    </aside>
  );
}
