import "./App.css";
import { BaseContainer } from "./components/BaseContainer";
import { Routing as Routes } from "./app/routes";

function App() {
  return (
    <div className="App">
      <BaseContainer>
        <Routes />
      </BaseContainer>
    </div>
  );
}

export default App;
