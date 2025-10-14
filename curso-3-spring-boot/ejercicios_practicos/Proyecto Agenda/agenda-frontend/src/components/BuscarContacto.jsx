import { useState } from 'react';
import { getContact } from '../api';
import { useNavigate, Link } from 'react-router-dom';

export default function BuscarContacto() {
  const [id, setId] = useState('');
  const [contacto, setContacto] = useState(null);
  const [error, setError] = useState('');

  const handleBuscar = async () => {
    try {
      const resultado = await getContact(id);
      setContacto(resultado);
      setError('');
    } catch (err) {
      setContacto(null);
      setError('Contacto no encontrado');
    }
  };

  return (
    <div className="min-h-screen bg-gray-100 py-10 px-4">
      <div className="bg-white p-6 rounded shadow-md w-full max-w-xl mx-auto">
        <h2 className="text-2xl font-bold mb-6 text-center text-gray-800">🔍 Buscar contacto por ID</h2>

        <div className="flex flex-col space-y-4 mb-6">
          <input
            type="text"
            placeholder="Ingrese ID"
            value={id}
            onChange={(e) => setId(e.target.value)}
            className="border border-gray-300 rounded px-4 py-2"
          />
          <div className="flex justify-center">
            <button
              onClick={handleBuscar}
              className="bg-indigo-600 text-white px-4 py-2 rounded hover:bg-indigo-700 transition"
            >
              🔍 Buscar
            </button>
          </div>
        </div>

        {error && <p className="text-center text-red-500 mb-4">{error}</p>}

        {contacto && (
          <div className="bg-gray-50 p-4 rounded shadow-sm mb-4">
            <h3 className="text-lg font-semibold text-gray-900 mb-2">Resultado:</h3>
            <p><strong>Nombre:</strong> {contacto.name}</p>
            <p><strong>Email:</strong> {contacto.email}</p>
            <p><strong>Teléfono:</strong> {contacto.phone}</p>
          </div>
        )}

        <Link
          to="/"
          className="block mt-4 bg-gray-700 text-white py-2 px-6 rounded hover:bg-gray-600 transition-colors text-center"
        >
          🔙 Volver
        </Link>
      </div>
    </div>
  );
}