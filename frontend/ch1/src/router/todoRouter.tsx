// todo와 관련된 기능을 분리하기 위한 목적으로 todoRouter 생성

import { Component, lazy, Suspense } from "react";

const Loading = () => <div>Loading....</div>;
const TodoIndex = lazy(() => import("../pages/todo/indexPage"));

const TodoList = lazy(() => import("../pages/todo/listPage"));

const todoRouter = () => {
  return {
    path: "todo",
    Component: TodoIndex,
    children: [
      {
        path: "list",
        element: (
          <Suspense fallback={<Loading />}>
            <TodoList />
          </Suspense>
        ),
      },
    ],
  };
};

export default todoRouter;
