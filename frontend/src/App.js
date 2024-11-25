import './App.css';
import { useEffect, useState } from "react";
import axios from 'axios';

function App() {
    const [message, setMessage] = useState('');
    const [stockData, setStockData] = useState(null);
    const [stockHistory, setStockHistory] = useState([]);
    const [symbol, setSymbol] = useState('');

    // Connect React to Backend API
    useEffect(() => {
        fetch('http://localhost:8080/api/stocks') // Backend point
            .then((response) => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then((data) => setMessage(data.message))
            .catch((error) => console.error("Error fetching message:", error));
    }, []);

    function handleInputChange(event) {
        setSymbol(event.target.value);
    }

    async function fetchStockData() {
        try {
            const response = await axios.get(`http://localhost:8080/api/stocks/${symbol}`);
            setStockData(response.data);
        } catch (error) {
            console.error("Error fetching stock data:", error);
        }
    }

    async function fetchStockHistory() {
        try {
            const response = await axios.get(`http://localhost:8080/api/stocks/history/${symbol}`);
            setStockHistory(response.data);
        } catch (error) {
            console.error("Error fetching stock data:", error);
        }
    }

    return (
        <div className="App">
            <header className="App-header"></header>
            <div>{message ? message : 'Loading...'}</div>
            <div>
                <input
                    type="text"
                    value={symbol}
                    onChange={handleInputChange}
                    placeholder="Enter stock symbol"
                />
                <button onClick={fetchStockData}>Get Stock Data</button>
                {stockData && <pre>{JSON.stringify(stockData, null, 2)}</pre>}
                <button onClick={fetchStockHistory}>Get Stock History</button>
                {stockHistory.length > 0 && (
                    <pre>{JSON.stringify(stockHistory, null, 2)}</pre>
                )}
            </div>
        </div>
    );
}

export default App;

