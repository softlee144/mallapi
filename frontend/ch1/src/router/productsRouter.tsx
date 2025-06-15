import { lazy, Suspense } from "react";
import { Navigate } from "react-router";

const ProductsIndex = lazy(() => import("../pages/products/indexPage"));
const ProductsList = lazy(() => import("../pages/products/listPage"));

const Loading = () => <div>Products Loading....</div>;

export default function productsRouter() {
  return {
    path: "products",
    Component: ProductsIndex,
    children: [
      {
        path: "list",
        element: (
          <Suspense fallback={<Loading />}>
            <ProductsList />
          </Suspense>
        ),
      },
      /* 기본 path 설정 : products의 기본 페이지*/
      {
        path: "",
        element: <Navigate to={"/products/list"}></Navigate>,
      },
    ],
  };
}
