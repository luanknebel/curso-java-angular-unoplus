import { environment } from "src/environments/environment";

const LOCALHOST = {
    url: "http://localhost:8080"
};

const PRODUCTION = {
    url: "http://localhost:8080"
};

const BASE_URL = environment.production ? PRODUCTION.url : LOCALHOST.url;
export const CADASTROPRODUTO_API = `${BASE_URL}/CadastroProdutoAPI/api/v1`;